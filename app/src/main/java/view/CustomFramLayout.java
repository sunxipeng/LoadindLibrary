package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.sunxipeng.loadindlibrary.R;

/**
 * Created by Administrator on 2016/6/1.
 */
public class CustomFramLayout extends FrameLayout {

    private static final int LOADING_TYPE = 1;
    private static final int ERROR_TYPE = 2;
    private static final int Empty_type = 3;
    private static final int SUCCESS_TYPE = 4;

    private final InflateviewListener inflateviewListener;
    private int TYPE = LOADING_TYPE;

    private final LayoutInflater layoutInflater;
    private View loading_layout;
    private View emptyView;
    private View errorView;
    private View successview;
    private View buttonview;

    public CustomFramLayout(Context context,InflateviewListener inflateviewListener) {
        super(context);
        //获取布局加载器
        layoutInflater = LayoutInflater.from(context);

        this.inflateviewListener = inflateviewListener;
        initView();
    }

    private void initView() {

        addLoadingView();

        addEmptyView();

        addErrorView();

        addButtonView();

        addsuccessView();
    }

    public void setOnLoadingClickListener(OnClickListener onClickListener){

        buttonview.findViewById(R.id.loading).setOnClickListener(onClickListener);
    }
    public void setOnErrorClickListener(OnClickListener onClickListener){

        buttonview.findViewById(R.id.error).setOnClickListener(onClickListener);
    }

    public void setOnEmptyClickListener(OnClickListener onClickListener){

        buttonview.findViewById(R.id.empty).setOnClickListener(onClickListener);
    }

    public void setOnSuccessClickListener(OnClickListener onClickListener){

        buttonview.findViewById(R.id.success).setOnClickListener(onClickListener);
    }
    private void addsuccessView() {

        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        successview = inflateviewListener.getView();
        addView(successview, layoutParams);
        successview.setVisibility(INVISIBLE);
    }

    private void addButtonView() {

        buttonview = layoutInflater.inflate(R.layout.layout, null);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(buttonview, layoutParams);
    }



    private void addErrorView() {

        errorView = layoutInflater.inflate(R.layout.error_view, null);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(errorView, layoutParams);
        errorView.setVisibility(INVISIBLE);
    }

    private void addEmptyView() {

        emptyView = layoutInflater.inflate(R.layout.empty_view, null);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(emptyView, layoutParams);
        emptyView.setVisibility(INVISIBLE);
    }


    private void addLoadingView() {

        loading_layout = layoutInflater.inflate(R.layout.laoding_view, null);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(loading_layout, layoutParams);
    }


    private void notifyallview() {


        switch (TYPE) {

            case LOADING_TYPE:
                emptyView.setVisibility(INVISIBLE);
                errorView.setVisibility(INVISIBLE);
                loading_layout.setVisibility(VISIBLE);
                successview.setVisibility(INVISIBLE);
                break;
            case ERROR_TYPE:

                loading_layout.setVisibility(INVISIBLE);
                emptyView.setVisibility(INVISIBLE);
                errorView.setVisibility(VISIBLE);
                successview.setVisibility(INVISIBLE);
                break;


            case Empty_type:

                loading_layout.setVisibility(INVISIBLE);
                errorView.setVisibility(INVISIBLE);
                emptyView.setVisibility(VISIBLE);
                successview.setVisibility(INVISIBLE);
                break;

            case SUCCESS_TYPE:

                loading_layout.setVisibility(INVISIBLE);
                errorView.setVisibility(INVISIBLE);
                emptyView.setVisibility(INVISIBLE);
                successview.setVisibility(VISIBLE);
                break;
        }

    }

    public void showloading(){

        TYPE = LOADING_TYPE;
        notifyallview();
    }

    public void showerror(){

        TYPE = ERROR_TYPE;
        notifyallview();
    }
    public void showempty(){

        TYPE = Empty_type;
        notifyallview();
    }

    public void showsuccess() {

        TYPE = SUCCESS_TYPE;
        notifyallview();
    }


    public interface InflateviewListener{

        View getView();
    }

}
