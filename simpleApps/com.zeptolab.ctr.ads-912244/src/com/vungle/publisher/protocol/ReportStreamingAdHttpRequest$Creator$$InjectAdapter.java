package com.vungle.publisher.protocol;

import a.a.b;
import a.a.l;
import com.vungle.publisher.protocol.ReportStreamingAdHttpRequest.Creator;
import java.util.Set;
import javax.inject.Provider;

public final class ReportStreamingAdHttpRequest$Creator$$InjectAdapter extends b implements a.b, Provider {
    private b a;

    public ReportStreamingAdHttpRequest$Creator$$InjectAdapter() {
        super("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Creator", "members/com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Creator", true, Creator.class);
    }

    public final void attach(l lVar) {
        this.a = lVar.a("com.vungle.publisher.protocol.ReportStreamingAdHttpRequest$Factory", (Object)Creator.class, getClass().getClassLoader());
    }

    public final Creator get() {
        Creator creator = new Creator();
        injectMembers(creator);
        return creator;
    }

    public final void getDependencies(Set set, Set set2) {
        set2.add(this.a);
    }

    public final void injectMembers(Creator creator) {
        creator.a = (Factory) this.a.get();
    }
}