package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest {
    private AdRequest a;
    private boolean b;
    private boolean c;

    public MediationAdRequest(AdRequest request, Context context, boolean shareLocation) {
        this.a = request;
        this.c = shareLocation;
        if (context == null) {
            this.b = true;
        } else {
            this.b = request.isTestDevice(context);
        }
    }

    public Integer getAgeInYears() {
        if (this.a.getBirthday() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.a.getBirthday());
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return instance2.get(6) < instance.get(6) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.a.getBirthday();
    }

    public Gender getGender() {
        return this.a.getGender();
    }

    public Set<String> getKeywords() {
        return this.a.getKeywords() == null ? null : Collections.unmodifiableSet(this.a.getKeywords());
    }

    public Location getLocation() {
        return (this.a.getLocation() == null || !this.c) ? null : new Location(this.a.getLocation());
    }

    public boolean isTesting() {
        return this.b;
    }
}