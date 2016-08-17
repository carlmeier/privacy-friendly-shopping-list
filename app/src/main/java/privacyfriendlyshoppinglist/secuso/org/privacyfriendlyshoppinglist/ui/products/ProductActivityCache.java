package privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.products;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.R;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.products.listadapter.ProductsAdapter;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.settings.SettingsKeys;

import java.util.ArrayList;

/**
 * Description:
 * Author: Grebiel Jose Ifill Brito
 * Created: 20.07.16 creation date
 */
public class ProductActivityCache
{
    private AppCompatActivity activity;
    private FloatingActionButton newListFab;
    private ProductsAdapter productsAdapter;
    private TextView totalAmountTextView;
    private TextView totalCheckedTextView;
    private TextView currencyTextView;
    private LinearLayout totalLayout;
    private RecyclerView recyclerView;
    private String listId;
    private String listName;
    private Boolean statisticsEnabled;

    public ProductActivityCache(AppCompatActivity activity, String listId, String listName, boolean statisticsEnabled)
    {
        this.activity = activity;
        this.listId = listId;
        this.listName = listName;
        this.statisticsEnabled = statisticsEnabled;

        productsAdapter = new ProductsAdapter(new ArrayList<>(), this);

        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(productsAdapter);

        newListFab = (FloatingActionButton) activity.findViewById(R.id.fab_new_product);
        totalAmountTextView = (TextView) activity.findViewById(R.id.textview_total_amount);
        totalCheckedTextView = (TextView) activity.findViewById(R.id.textview_total_checked);
        totalLayout = (LinearLayout) activity.findViewById(R.id.layout_total);
        currencyTextView = (TextView) activity.findViewById(R.id.textview_currency);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String defaultCurrency = activity.getResources().getString(R.string.currency);
        String currency = sharedPreferences.getString(SettingsKeys.CURRENCY, defaultCurrency);
        currencyTextView.setText(currency);
    }

    public AppCompatActivity getActivity()
    {
        return activity;
    }

    public FloatingActionButton getNewListFab()
    {
        return newListFab;
    }

    public ProductsAdapter getProductsAdapter()
    {
        return productsAdapter;
    }

    public String getListId()
    {
        return listId;
    }

    public TextView getTotalAmountTextView()
    {
        return totalAmountTextView;
    }

    public TextView getTotalCheckedTextView()
    {
        return totalCheckedTextView;
    }

    public RecyclerView getRecyclerView()
    {
        return recyclerView;
    }

    public LinearLayout getTotalLayout()
    {
        return totalLayout;
    }

    public Boolean getStatisticsEnabled()
    {
        return statisticsEnabled;
    }

    public String getListName()
    {
        return listName;
    }
}
