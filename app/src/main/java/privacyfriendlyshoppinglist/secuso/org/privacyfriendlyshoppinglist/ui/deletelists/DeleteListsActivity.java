package privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.deletelists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.R;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.framework.context.AbstractInstanceFactory;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.framework.context.InstanceFactory;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.logic.shoppingList.business.ShoppingListService;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.logic.shoppingList.business.domain.ListDto;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.deletelists.listadapter.DeleteListsAdapter;
import privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.deletelists.listeners.DeleteOnClickListener;

import java.util.List;

/**
 * Description:
 * Author: Grebiel Jose Ifill Brito
 * Created: 09.07.16 creation date
 */
public class DeleteListsActivity extends AppCompatActivity
{
    private ShoppingListService shoppingListService;
    private DeleteListsCache cache;

    @Override
    protected final void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_lists_activity);

        AbstractInstanceFactory instanceFactory = new InstanceFactory(getApplicationContext());
        this.shoppingListService = (ShoppingListService) instanceFactory.createInstance(ShoppingListService.class);
        cache = new DeleteListsCache(this);

        updateListView();

        cache.getDeleteFab().setOnClickListener(new DeleteOnClickListener(cache));

        overridePendingTransition(0, 0);
    }

    public void updateListView()
    {
        cache.getDeleteListsAdapter().setShoppingList(shoppingListService.getAllListDtos());
        cache.getDeleteListsAdapter().notifyDataSetChanged();
    }

    public void reorderListView()
    {
        // todo: do not use here. But can be taken as an example for the products
        DeleteListsAdapter deleteListsAdapter = cache.getDeleteListsAdapter();
        List<ListDto> shoppingList = deleteListsAdapter.getShoppingList();
        List<ListDto> reorderedList = shoppingListService.moveSelectedToEnd(shoppingList);
        deleteListsAdapter.setShoppingList(reorderedList);
        deleteListsAdapter.notifyDataSetChanged();
    }
}
