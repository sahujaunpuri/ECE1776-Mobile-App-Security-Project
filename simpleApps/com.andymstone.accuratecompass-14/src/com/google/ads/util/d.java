package com.google.ads.util;

import android.os.Build;

class d {
    static final d d;
    static final d e;
    public final String a;
    public final String b;
    public final String c;

    static {
        d = new d();
        e = new d("unknown", "generic", "generic");
    }

    d() {
        this.a = Build.BOARD;
        this.b = Build.DEVICE;
        this.c = Build.BRAND;
    }

    d(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    private static boolean a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str == str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a(this.a, dVar.a) && a(this.b, dVar.b) && a(this.c, dVar.c);
    }

    public int hashCode() {
        int i = 0;
        if (this.a != null) {
            i = 0 + this.a.hashCode();
        }
        if (this.b != null) {
            i += this.b.hashCode();
        }
        return this.c != null ? i + this.c.hashCode() : i;
    }
}