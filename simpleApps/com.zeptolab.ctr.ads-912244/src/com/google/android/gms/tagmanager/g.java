package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = a.I.toString();
    }

    public g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public d.a u(Map map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (NameNotFoundException e) {
            bh.c("App name is not found.", e);
            return di.ku();
        }
    }
}