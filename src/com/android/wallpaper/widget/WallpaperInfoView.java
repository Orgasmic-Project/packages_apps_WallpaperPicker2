/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.wallpaper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.wallpaper.R;

import java.util.List;

/** A view for displaying wallpaper info. */
public class WallpaperInfoView extends LinearLayout {

    private TextView mTitle;
    private TextView mSubtitle1;
    private TextView mSubtitle2;

    public WallpaperInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTitle = findViewById(R.id.wallpaper_info_title);
        mSubtitle1 = findViewById(R.id.wallpaper_info_subtitle1);
        mSubtitle2 = findViewById(R.id.wallpaper_info_subtitle2);
    }

    /** Populates wallpaper info. */
    public void populateWallpaperInfo(List<String> attributions, boolean showMetadata) {
        // Reset
        mTitle.setText(null);
        mSubtitle1.setText(null);
        mSubtitle1.setVisibility(View.GONE);
        mSubtitle2.setText(null);
        mSubtitle2.setVisibility(View.GONE);

        if (attributions.size() > 0 && attributions.get(0) != null) {
            mTitle.setText(attributions.get(0));
        }

        if (showMetadata) {
            if (attributions.size() > 1 && attributions.get(1) != null) {
                mSubtitle1.setVisibility(View.VISIBLE);
                mSubtitle1.setText(attributions.get(1));
            }

            if (attributions.size() > 2 && attributions.get(2) != null) {
                mSubtitle2.setVisibility(View.VISIBLE);
                mSubtitle2.setText(attributions.get(2));
            }
        }
    }
}
