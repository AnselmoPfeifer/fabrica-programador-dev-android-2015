package com.anselmopfeifer.htapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.anselmopfeifer.htapp.R;
import com.anselmopfeifer.htapp.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Anselmo on 20/10/2015.
 */
public class UserListAdapter extends ArrayAdapter<User> {

    public UserListAdapter(Context context, List<User> userList) {
        super(context, R.layout.item_user, userList);
    }

    @Override
    public View getView(int position, View item, ViewGroup parent) {
        final ViewHolder holder;
        if(item == null){
            item = View.inflate(getContext(), R.layout.item_user, null);
            holder = new ViewHolder();

            ButterKnife.bind(holder, item);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }
        final User user = getItem(position);
        holder.userName.setText(user.getNome());
        holder.userEmail.setText(user.getEmail());
        return item;
    }

    public class ViewHolder{
        @Bind(R.id.user_nome)
        TextView userName;
        @Bind(R.id.user_email)
        TextView userEmail;
    }
}
