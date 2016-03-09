package com.sm;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    private Context mContext;
    private View view;
    private String[] mMenuTitles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.fragment_tag);
        String tag = this.getArguments().getString("key");
        tv.setText("这是选择" + tag + "的内容");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        initViews();
    }


    private void initViews() {
        ListView listView = (ListView) view.findViewById(R.id.center_list);

        // 初始化菜单列表
        mMenuTitles = getResources().getStringArray(R.array.menu_array);
//        mMenuListView.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, mMenuTitles));
//        mMenuListView.setOnItemClickListener(new DrawerItemClickListener());

        listView.setAdapter(new ArrayAdapter<String>(mContext,
                R.layout.drawer_list_item, mMenuTitles));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity)getActivity()).setRightMenu(position);
            }
        });

    }

}
