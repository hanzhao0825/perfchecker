package perfchecker;

import java.util.ArrayList;

public class ListenerList {
	public static ArrayList<String> list;
	static {
		list = new ArrayList<String>();
	    list.add("android.widget.AbsListView$OnScrollListener");
	    list.add("android.widget.AdapterView$OnItemClickListener");
	    list.add("android.widget.AdapterView$OnItemLongClickListener");
	    list.add("android.widget.AdapterView$OnItemSelectedListener");
	    list.add("android.view.View$OnClickListener");
	    list.add("android.view.View$OnLongClickListener");
	    list.add("android.view.View$OnFocusChangeListener");
	    list.add("android.view.View$OnKeyListener");
	    list.add("android.view.View$OnTouchListener");
	    list.add("android.view.View$OnCreateContextMenuListener");
	    list.add("android.widget.CalendarView$OnDateChangeListener");
	    list.add("android.widget.AutoCompleteTextView$OnDismissListener");
	    list.add("android.widget.Chronometer$OnChronometerTickListener");
	    list.add("android.widget.CompoundButton$OnCheckedChangeListener");
	    list.add("android.widget.DatePicker$OnDateChangedListener");
	    list.add("android.widget.ExpandableListView$OnChildClickListener");
	    list.add("android.widget.ExpandableListView$OnGroupClickListener");
	    list.add("android.widget.ExpandableListView$OnGroupCollapseListener");
	    list.add("android.widget.ExpandableListView$OnGroupExpandListener");
	    list.add("android.widget.NumberPicker$OnScrollListener");
	    list.add("android.widget.NumberPicker$OnValueChangeListener");
	    list.add("android.widget.PopupMenu$OnDismissListener");
	    list.add("android.widget.PopupMenu$OnMenuItemClickListener");
	    list.add("android.widget.PopupWindow$OnDismissListener");
	    list.add("android.widget.RadioGroup$OnCheckedChangeListener");
	    list.add("android.widget.RatingBar$OnRatingBarChangeListener");
	    list.add("android.widget.SearchView$OnCloseListener");
	    list.add("android.widget.SearchView$OnQueryTextListener");
	    list.add("android.widget.SearchView$OnSuggestionListener");
	    list.add("android.widget.SeekBar$OnSeekBarChangeListener");
	    list.add("android.widget.ShareActionProvider$OnShareTargetSelectedListener");
	    list.add("android.widget.SlidingDrawer$OnDrawerCloseListener");
	    list.add("android.widget.SlidingDrawer$OnDrawerOpenListener");
	    list.add("android.widget.SlidingDrawer$OnDrawerScrollListener");
	    list.add("android.widget.TabHost$OnTabChangeListener");
	    list.add("android.widget.TextView$OnEditorActionListener");
	    list.add("android.widget.TimePicker$OnTimeChangedListener");
	    list.add("android.widget.ZoomButtonsController$OnZoomListener");
	}
}
