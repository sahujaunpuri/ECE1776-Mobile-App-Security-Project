package com.vungle.publisher.db.model;

import a.a.b;
import a.a.l;
import com.vungle.publisher.ak.a;
import com.vungle.publisher.db.DatabaseHelper;
import java.util.Set;

public final class BaseModel$Factory$$InjectAdapter extends b implements a.b {
    private b a;

    public BaseModel$Factory$$InjectAdapter() {
        super(null, "members/com.vungle.publisher.db.model.BaseModel$Factory", false, a.class);
    }

    public final void attach(l lVar) {
        this.a = lVar.a("com.vungle.publisher.db.DatabaseHelper", (Object)a.class, getClass().getClassLoader());
    }

    public final void getDependencies(Set set, Set set2) {
        set2.add(this.a);
    }

    public final void injectMembers(a aVar) {
        aVar.b = (DatabaseHelper) this.a.get();
    }
}