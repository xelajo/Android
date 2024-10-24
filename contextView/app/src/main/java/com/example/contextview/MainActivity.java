package com.example.contextview;


import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contextview.R;

public class MainActivity extends AppCompatActivity {

    ActionMode mActionMode;  // To hold the current ActionMode
    TextView textView;       // The TextView we'll use for the Contextual Action Bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Set a long click listener to start the contextual action mode
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) {
                    return false; // If ActionMode is already active, don't start another
                }

                // Start the ActionMode and pass the ActionMode.Callback implementation
                mActionMode = startActionMode(mActionModeCallback);
                v.setSelected(true);  // Highlight the selected text
                return true;  // Return true to indicate the long-click was handled
            }
        });
    }

    // ActionMode.Callback implementation
    private final ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.contextual_menu, menu);  // Inflate a contextual menu
            return true;  // Return true to show the contextual action mode
        }

        // Called when an action button is clicked
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_delete) {
                // Clear the text from the TextView
                textView.setText("");  // Clears the content of the TextView

                // Show a Toast to confirm the action
                Toast.makeText(MainActivity.this, "Text Deleted", Toast.LENGTH_SHORT).show();

                mode.finish();  // Close the ActionMode
                return true;
            } else {
                return false;
            }
        }


        // Called when the action mode is destroyed
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;  // Reset ActionMode
        }

        // Called to refresh the action mode's menu (optional)
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;  // Return false if no updates are needed
        }
    };
}