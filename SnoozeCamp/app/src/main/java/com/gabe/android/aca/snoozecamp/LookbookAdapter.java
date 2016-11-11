package com.gabe.android.aca.snoozecamp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LookbookAdapter extends RecyclerView.Adapter<LookbookViewHolder> {

    private List<Lookbook> mImageList;

    private LayoutInflater mInflater;

    private Context mContext;


    String[] UriArray = new String[2];
    ArrayList<String> uriArray = new ArrayList<>();



    // Adapter
    public LookbookAdapter(Context context) {

        this.mContext = context;

        this.mInflater = LayoutInflater.from(context);

        this.mImageList = new ArrayList<>();

        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb862414fb5c9833759ee/1475262566969/Screen+Shot+2016-09-08+at+2.51.14+PM.png");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb862b3db2bd7ce26c08a/1475262574128/slumber.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb863414fb5c9833759f5/1475262612332/les.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb865414fb5c983375a37/1475262572578/Forkate.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb865b3db2bd7ce26c0c8/1475262587807/les-sleeping.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb867414fb5c983375a3c/1475262581865/katie-sleeping.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb867b3db2bd7ce26c0d4/1475262575656/katie.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb869414fb5c983375a6c/1475262578063/slumber3.jpg");
        uriArray.add("https://static1.squarespace.com/static/57e96475ff7c509e4d2479cc/57ed35b546c3c4396dc43dc7/57eeb86ab3db2bd7ce26c10b/1475262599167/slumber2.jpg");


    }


    @Override
    public LookbookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.lookbook_row, parent, false);

        LookbookViewHolder viewHolder = new LookbookViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(LookbookViewHolder holder, int position) {

        String path = uriArray.get(position);



        Picasso.with(mContext).load(path).placeholder(R.color.colorAccent).into(holder.mimageView);




    }



    @Override
    public int getItemCount() {
        return (mImageList == null) ? 0 : mImageList.size();
    }


    public void setLookbookList(List<Lookbook> ImageList) {
        this.mImageList.clear();
        this.mImageList.addAll(ImageList);
        notifyDataSetChanged();

    }


    //getter method used
    public List<Lookbook> getLookbookList() {
        return mImageList;
    }

}

