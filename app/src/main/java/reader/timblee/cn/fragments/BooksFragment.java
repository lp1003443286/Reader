package reader.timblee.cn.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import reader.timblee.cn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksFragment extends Fragment {


    public BooksFragment() {
        
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_books, container, false);
    }

}
