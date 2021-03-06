/*
 * Copyright 2012 the original author or authors.
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
package org.springframework.android.twittersearch;

import java.util.List;

import org.springsource.android.showcase.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Roy Clarkson
 */
public class TweetListAdapter extends BaseAdapter {

    private List<Tweet> tweets;
    private final LayoutInflater layoutInflater;

    public TweetListAdapter(Context context, List<Tweet> tweets) {
        this.tweets = tweets;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return tweets != null ? tweets.size() : 0;
    }

    public Tweet getItem(int position) {
        return tweets.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.twitter_timeline_list_item, parent, false);
        }

        Tweet tweet = getItem(position);
        if (tweet != null) {
            TextView t = (TextView) convertView.findViewById(R.id.tweet_from_user);
            t.setText(tweet.getFromUser());

            t = (TextView) convertView.findViewById(R.id.tweet_text);
            t.setText(tweet.getText());
        }

        return convertView;
    }

}
