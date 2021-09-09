package id.ac.umn.week03_33738;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DafterKataAdapter extends RecyclerView.Adapter<DafterKataAdapter.KataViewHolder> {
    private final LinkedList<String> mDaftarKata;
    private LayoutInflater mInflater;

    DafterKataAdapter(Context context, LinkedList<String> daftarKata) {
        mInflater = LayoutInflater.from(context);
        mDaftarKata = daftarKata;
    }

    @NonNull
    @Override
    public DafterKataAdapter.KataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.daftarkata_item, parent, false);
        return new KataViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DafterKataAdapter.KataViewHolder holder, int position) {
        String mCurrent = mDaftarKata.get(position);
        holder.kataItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mDaftarKata.size();
    }

    class KataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView kataItemView;
        final DafterKataAdapter mAdapter;

        public KataViewHolder(@NonNull View itemView, DafterKataAdapter adapter) {
            super(itemView);
            kataItemView = itemView.findViewById(R.id.kata);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mDaftarKata.get(mPosition);
            mDaftarKata.set(mPosition, element + " pernah diklik ");
            mAdapter.notifyDataSetChanged();
            Toast.makeText(v.getContext(), element +" dipilih", Toast.LENGTH_LONG).show();
        }
    }
}
