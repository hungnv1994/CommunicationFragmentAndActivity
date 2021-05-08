package com.suningstudio.comunicationactivityandfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnTapFavouriteListener{
    // 0: chưa chọn, 1: đã chọn
    int status = 0;
    FragmentManager fm;
    OnTapFavouriteListener onTapFavouriteListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        BlankFragment fragment = (BlankFragment) fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null){
            fragment = BlankFragment.newInstance();
            fragment.setOnTapFavouriteListener(this);
            setOnTapFavouriteListener(fragment);
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.root_menu, menu);
        btnFavourite = menu.findItem(R.id.btn_favourite);
        return true;
    }

    public void setOnTapFavouriteListener(OnTapFavouriteListener onTapFavouriteListener) {
        this.onTapFavouriteListener = onTapFavouriteListener;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.btn_favourite:
                if (status == 0) {
                    status += 1;
                    item.setIcon(R.drawable.ic_favorite_enable);
                    onTapFavouriteListener.action();
                } else {
                    status -= 1;
                    item.setIcon(R.drawable.ic_favorite_disable);
                    onTapFavouriteListener.action();
                }

                break;
            default:
                break;
        }
        return true;
    }

    MenuItem btnFavourite;

    // Phương thức (callback) này được gọi khi chúng ta click button favourite ở Fragment
    @Override
    public void action() {
        if (status == 0) {
            status += 1;
            btnFavourite.setIcon(R.drawable.ic_favorite_enable);
        } else {
            status -= 1;
            btnFavourite.setIcon(R.drawable.ic_favorite_disable);
        }
    }
}