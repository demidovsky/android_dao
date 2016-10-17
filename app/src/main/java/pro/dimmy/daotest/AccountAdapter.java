package pro.dimmy.daotest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ddemidovskiy on 17.10.2016.
 */

public class AccountAdapter extends ArrayAdapter<Account>
{
    private Context context;
    private int resource;
    private List<Account> objects;
    private LayoutInflater inflater;

    public AccountAdapter(Context context, int resource, List<Account> objects)
    {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = LayoutInflater.from(context);
    }


    @Nullable
    @Override
    public Account getItem(int position)
    {
        Log.d("xxx", "getItem");
        return objects.get(position);
    }


    @Override
    public int getCount()
    {
        Log.d("xxx", "getCount");
        return objects.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.d("xxx", "getView");
        convertView = inflater.inflate(R.layout.item_account, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(objects.get(position).getName());

        return convertView;
    }
}
