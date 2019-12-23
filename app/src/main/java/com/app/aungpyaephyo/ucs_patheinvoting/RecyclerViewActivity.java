package com.app.aungpyaephyo.ucs_patheinvoting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardsAdapter adapter;
    private List<Card> albumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView =  findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new CardsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        Bundle selection=getIntent().getExtras();
        if(selection!=null){
            String selected=selection.getString("data");
            if(selected.equals("boys")){
                Toast.makeText(this,selected,Toast.LENGTH_LONG).show();
            }
            else {
                prepareAlbumsGirls();
            }

        }

    }
    private void prepareAlbumsGirls() {

        Card a = new Card("IU", "1CST-1", R.drawable.album1);
        albumList.add(a);

        a = new Card("IU", "1CST-2", R.drawable.album2);
        albumList.add(a);

        a = new Card("IU", "1CST-3", R.drawable.album3);
        albumList.add(a);

        a = new Card("IU", "1CST-4", R.drawable.album4);
        albumList.add(a);

        a = new Card("IU", "1CST-5", R.drawable.album5);
        albumList.add(a);

        a = new Card("IU", "1CST-6", R.drawable.album1);
        albumList.add(a);

        a = new Card("IU", "1CST-7", R.drawable.album2);
        albumList.add(a);

        a = new Card("IU", "1CST-8", R.drawable.album3);
        albumList.add(a);

        a = new Card("IU", "1CST-9", R.drawable.album4);
        albumList.add(a);

        a = new Card("IU", "1CST-10", R.drawable.album5);
        albumList.add(a);

        a = new Card("IU", "1CST-11", R.drawable.album1);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
