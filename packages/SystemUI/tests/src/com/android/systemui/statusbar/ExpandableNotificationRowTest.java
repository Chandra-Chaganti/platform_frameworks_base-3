/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.systemui.statusbar;

import static org.mockito.Mockito.mock;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.FlakyTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.android.systemui.SysuiTestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@SmallTest
@RunWith(AndroidJUnit4.class)
@FlakyTest
public class ExpandableNotificationRowTest extends SysuiTestCase {

    private ExpandableNotificationRow mGroup;
    private NotificationTestHelper mNotificationTestHelper;

    @Before
    public void setUp() throws Exception {
        mNotificationTestHelper = new NotificationTestHelper(mContext);
        mGroup = mNotificationTestHelper.createGroup();
    }

    @Test
    public void testGroupSummaryNotShowingIconWhenPublic() {
        mGroup.setSensitive(true, true);
        mGroup.setHideSensitive(true, false, 0, 0);
        Assert.assertTrue(mGroup.isSummaryWithChildren());
        Assert.assertFalse(mGroup.isShowingIcon());
    }

    @Test
    public void testNotificationHeaderVisibleWhenAnimating() {
        mGroup.setSensitive(true, true);
        mGroup.setHideSensitive(true, false, 0, 0);
        mGroup.setHideSensitive(false, true, 0, 0);
        Assert.assertTrue(mGroup.getChildrenContainer().getVisibleHeader().getVisibility()
                == View.VISIBLE);
    }

}
