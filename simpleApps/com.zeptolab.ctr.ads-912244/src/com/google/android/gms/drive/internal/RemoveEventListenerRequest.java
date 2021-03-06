package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final DriveId CS;
    final int Dm;
    final int wj;

    static {
        CREATOR = new aj();
    }

    RemoveEventListenerRequest(int i, DriveId driveId, int i2) {
        this.wj = i;
        this.CS = driveId;
        this.Dm = i2;
    }

    public RemoveEventListenerRequest(DriveId driveId, int i) {
        this(1, driveId, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        aj.a(this, parcel, i);
    }
}