package com.mologiq.analytics;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

class v implements Runnable {
    private final List a;
    private final Map b;
    private final String c;
    private final long d;
    private final String e;
    private final WeakReference f;

    public v(Context context, List list, Map map, String str, int i, String str2) {
        this.f = new WeakReference(context);
        this.a = list;
        this.b = map;
        this.c = str;
        this.d = (long) i;
        this.e = str2;
    }

    public void run() {
        Context context = (Context) this.f.get();
        if (context != null) {
            new u(context, this.a, this.b, this.c, this.d, this.e).execute(new Object[0]);
        }
    }
}