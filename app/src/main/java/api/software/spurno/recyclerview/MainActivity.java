package api.software.spurno.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");
        initImages();
    }
    private void initImages(){
        Log.d(TAG, "initImages: prearing images");
        mImagesUrl.add("https://avatars3.githubusercontent.com/u/11821883?s=460&v=4");
        mNames.add("Faruk Ahmed");

        mImagesUrl.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Canada");

        mImagesUrl.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Australia");

        mImagesUrl.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Singapore");

        mImagesUrl.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Bangladesh");

        mImagesUrl.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("India");

        mImagesUrl.add("https://avatars3.githubusercontent.com/u/11821883?s=460&v=4");
        mNames.add("Pakisthan");
        RecyclerView();
    }
    private void RecyclerView (){
        Log.d(TAG, "RecyclerView: craated");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerAdapter adapter = new RecyclerAdapter(this, mNames, mImagesUrl);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
