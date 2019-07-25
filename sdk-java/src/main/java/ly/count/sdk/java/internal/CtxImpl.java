package ly.count.sdk.java.internal;

import java.io.File;

import ly.count.sdk.internal.Ctx;
import ly.count.sdk.internal.InternalConfig;
import ly.count.sdk.internal.Log;

/**
 * {@link Ctx} implementation
 */
public class CtxImpl implements Ctx {
    private static final Log.Module L = Log.module("CtxImpl");
    private SDK sdk;
    private InternalConfig config;
    private File directory;
    private String view;

    private boolean expired = false;

    public CtxImpl(SDK sdk, InternalConfig config, File directory) {
        this.sdk = sdk;
        this.config = config;
        this.directory = directory;
    }

    public CtxImpl(SDK sdk, InternalConfig config, File directory, String view) {
        this.sdk = sdk;
        this.config = config;
        this.directory = directory;
        this.view = view;
    }

    @Override
    public File getContext() {
        if (expired) {
            L.wtf("Ctx is expired");
        }
        return directory;
    }

    @Override
    public InternalConfig getConfig() {
        return config;
    }

    @Override
    public SDK getSDK() {
        return sdk;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    public String getView() {
        return view;
    }

    public void expire() {
        config = null;
        directory = null;
        view = null;
    }
}
