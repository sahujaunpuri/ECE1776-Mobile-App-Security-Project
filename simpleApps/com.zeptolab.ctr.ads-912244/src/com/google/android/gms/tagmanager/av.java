package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class av implements bl {
    private HttpClient Vi;

    av() {
    }

    private InputStream a(HttpClient httpClient, HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            bh.v("Success response");
            return httpResponse.getEntity().getContent();
        } else {
            String str = "Bad response: " + statusCode;
            if (statusCode == 404) {
                throw new FileNotFoundException(str);
            }
            throw new IOException(str);
        }
    }

    private void a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public InputStream bo(String str) {
        this.Vi = jg();
        return a(this.Vi, this.Vi.execute(new HttpGet(str)));
    }

    public void close() {
        a(this.Vi);
    }

    HttpClient jg() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, WebRequest.DEFAULT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, WebRequest.DEFAULT_TIMEOUT);
        return new DefaultHttpClient(basicHttpParams);
    }
}