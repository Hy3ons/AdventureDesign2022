package cnu.kicksafe;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Profile> list = new ArrayList<>();

    public ProfileAdapter (List<Profile> list) {
        this.list = list;
    }

    public ProfileAdapter () {
        this(new ArrayList<>());
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == 0)
            return new ProfileHolder(inflater.inflate(R.layout.activity_profile, parent, false));
        else
            //추후에 + 공간의 어댑터를 만들 예정
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Profile profile = list.get(position);

        ProfileHolder ph = (ProfileHolder) holder;
        ph.setProfile(profile);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ProfileHolder extends RecyclerView.ViewHolder {
        private final TextView name, speed, helmetCount, timeCount;
        private final ImageView profileImage;
        public ProfileHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            speed = itemView.findViewById(R.id.speedTextView);
            helmetCount = itemView.findViewById(R.id.takeHelmetView);
            timeCount = itemView.findViewById(R.id.usedTimeTextView);

            profileImage = itemView.findViewById(R.id.profileImageView);
        }

        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        public void setProfile(Profile profile) {
            name.setText(profile.getName());
            speed.setText(String.format("%.1f", profile.getSpeed()));
            helmetCount.setText(profile.getHelmetCount()+"");
            timeCount.setText(profile.getUsedTime()+"");

            if (profile.getProfileImage() == null) {
                //기본적인 이미지로 대체한다. 나중에 할 예정.
            } else {
                profileImage.setImageBitmap(profile.getProfileImage());
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }
}
