package privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.deleteproducts;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.R;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.deleteproducts.listadapter.DeleteProductsAdapter;

import java.util.ArrayList;

/**
 * Description:
 * Author: Grebiel Jose Ifill Brito
 * Created: 21.07.16 creation date
 */
public class DeleteProductsCache
{
    private AppCompatActivity activity;
    private FloatingActionButton deleteFab;
    private DeleteProductsAdapter deleteProductsAdapter;
    private String listId;

    public DeleteProductsCache(DeleteProductsActivity activity, String listId)
    {
        this.activity = activity;
        this.listId = listId;

        deleteProductsAdapter = new DeleteProductsAdapter(new ArrayList<>(), activity);

        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(deleteProductsAdapter);

        deleteFab = (FloatingActionButton) activity.findViewById(R.id.fab_delete_products);
    }

    public AppCompatActivity getActivity()
    {
        return activity;
    }

    public FloatingActionButton getDeleteFab()
    {
        return deleteFab;
    }

    public DeleteProductsAdapter getDeleteProductsAdapter()
    {
        return deleteProductsAdapter;
    }

    public String getListId()
    {
        return listId;
    }
}