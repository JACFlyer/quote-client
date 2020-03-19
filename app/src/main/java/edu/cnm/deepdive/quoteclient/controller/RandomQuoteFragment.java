package edu.cnm.deepdive.quoteclient.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.quoteclient.R;

public class RandomQuoteFragment extends Fragment {

  private MainViewModel viewModel;
  private TextView quoteText;
  private TextView quoteSource;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_random_quote, container, false);
    quoteText = root.findViewById(R.id.quote_text);
    root.setOnClickListener((view) -> viewModel.refresh());
    return root;
  }

  @SuppressWarnings("ConstantConditions")
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    //  viewModel returns live data which must be observed.
    viewModel.getQuote().observe(getViewLifecycleOwner(), (quote) ->
        quoteText.setText(quote.getText()));
  }
}