package com.android.settings.baikalos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.R;
import com.android.settings.dashboard.SummaryLoader;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.Indexable;

public class StartBe extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBe();
        finish();
    }

    private void startBe(){
        Intent baikalosExtrasIntent = new Intent();
        baikalosExtrasIntent.setClassName("ru.baikalos.extras", "ru.baikalos.extras.SubSettingsActivity");
        startActivity(baikalosExtrasIntent);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.BAIKALOS_METRICS;
    }

    private static class SummaryProvider implements SummaryLoader.SummaryProvider {

        private final Context mContext;
        private final SummaryLoader mSummaryLoader;

        public SummaryProvider(Context context, SummaryLoader summaryLoader) {
            mContext = context;
            mSummaryLoader = summaryLoader;
        }

        @Override
        public void setListening(boolean listening) {
            // TODO
            //String mCustomSummary = Settings.System.getString(
            //        mContext.getContentResolver(), Settings.System.AE_SETTINGS_SUMMARY);
            if (listening) {
                // TODO
                /*
                if (TextUtils.isEmpty(mCustomSummary)) {
                    mSummaryLoader.setSummary(this,
                            mContext.getString(R.string.baikalosextras_dashboard_summary));
                } else if (mCustomSummary.contains("\n")) {
                    String[] summaries = mCustomSummary.split("\n");
                    int selection = (int) (Math.random() * summaries.length);
                    mSummaryLoader.setSummary(this, summaries[selection]);
                } else {
                    mSummaryLoader.setSummary(this, mCustomSummary);
                }
                */
            }
        }
    }

    public static final SummaryLoader.SummaryProviderFactory SUMMARY_PROVIDER_FACTORY
            = new SummaryLoader.SummaryProviderFactory() {
        @Override
        public SummaryLoader.SummaryProvider createSummaryProvider(Activity activity,
                                                                   SummaryLoader summaryLoader) {
            return new SummaryProvider(activity, summaryLoader);
        }
    };
}
