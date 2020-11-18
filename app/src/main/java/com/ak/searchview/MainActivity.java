package com.ak.searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Nine", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "One", "Tenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Two", "Eleventh"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Three", "Twelveth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Four", "Thirteenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Five", "Fourteenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Six", "Fifteenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Seven", "Sixteenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Eight", "Seventeenth"));
        exampleList.add(new ExampleItem(R.drawable.ic_ac_unit_black_24dp, "Nine", "Eighteenth"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}