package by.easyandroid.template.conference.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import by.easyandroid.template.conference.R;
import by.easyandroid.template.conference.filter.FilterSet;
import by.easyandroid.template.conference.filter.ReportDayFilter;
import by.easyandroid.template.conference.filter.ReportSectionFilter;
import by.easyandroid.template.conference.model.Report;
import by.easyandroid.template.conference.model.Section;
import by.easyandroid.template.conference.util.DateSpinnerProxy;
import by.easyandroid.template.conference.util.DateUtil;
import by.easyandroid.template.conference.util.adapter.ScheduleAdapter;

public class ScheduleActivity extends BasicActivity implements OnItemClickListener {

	private static final String DAY_FILTER = "day";

	private static final String SECTION_FILTER = "section";
	
	private FilterSet<Report> filterSet = new FilterSet<Report>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		initSpinner(R.id.spinnerSection, sectionService.getAll(), new SectionSpinnerSelectedListener());
		initSpinner(R.id.spinnerDate, DateUtil.getReportDaysProxy(reportService.getAll()), new DaySpinnerSelectedListener());
	}

	protected void initListView() {
		initListView(R.id.listSchedule, new ScheduleAdapter(ScheduleActivity.this, reportService.getAll(filterSet.getFilters())), this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		showReportDetails(id);
	}
	
	class DaySpinnerSelectedListener implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// Add section filter
			filterSet.addFilter(DAY_FILTER, new ReportDayFilter(((DateSpinnerProxy)parent.getItemAtPosition(position)).getDate()));
			initListView();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		}
	}
	
	class SectionSpinnerSelectedListener implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// Add section filter
			filterSet.addFilter(SECTION_FILTER, new ReportSectionFilter((Section) parent.getItemAtPosition(position)));
			initListView();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		}
	}	
}