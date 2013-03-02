package by.easyandroid.template.conference.util.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import by.easyandroid.template.conference.R;
import by.easyandroid.template.conference.model.Report;
import by.easyandroid.template.conference.util.AndroidUtil;

public class ReportsAdapter extends ListAdapter<Report> {

	private static final String TIME_FORMAT = "%02d:%02d";
	
	public ReportsAdapter(Context context, List<Report> reports) {
		super(context, reports, R.layout.list_elem_reports);
	}
	
	@Override
	protected void fillView(Report item, View view) {
		AndroidUtil.setText(view, R.id.txtReportTitle, item.getTitle());
		AndroidUtil.setText(view, R.id.txtReportAuthor, item.getReporter().getName());
		AndroidUtil.setText(view, R.id.txtReportDateTime, String.format(TIME_FORMAT, item.getTime().getHours(), item.getTime().getMinutes()));
		AndroidUtil.setText(view, R.id.txtReportSection, item.getSection().getName());
	}
}