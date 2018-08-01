package com.component.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.acmenxd.frame.basis.FrameActivityFragmentViewHelper;

import com.ftoutiao.component.R;

/**
 * Created by alan on 2017/11/5.
 */

public class ProgressDialogFragment extends DialogFragment {

    protected static final String PROGRESS_DIALOG_TAG = "Progress_Dialog";


    public static void show(FragmentActivity activity, String msg, boolean cancelable) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Bundle args = new Bundle();
        args.putString("msg", msg);

        ProgressDialogFragment f = new ProgressDialogFragment();
        f.setCancelable(cancelable);
        f.setArguments(args);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.add(f, PROGRESS_DIALOG_TAG);
        try {
            ft.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hide(FragmentActivity activity) {
        if (activity != null && !activity.isFinishing()) {
            FragmentManager manager = activity.getSupportFragmentManager();
            ProgressDialogFragment fragment = (ProgressDialogFragment) manager
                    .findFragmentByTag(PROGRESS_DIALOG_TAG);
            if (fragment != null) {
                try {
                    manager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String message = args.getString("msg");

//        ProgressDialog dialog = new ProgressDialog(getActivity());

//        dialog.addContentView(FrameActivityFragmentViewHelper.getLoadingDialogView(getActivity()),
//                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        dialog.setIndeterminate(true);
//        dialog.setCanceledOnTouchOutside(false);

        Dialog mLoadingDialog = new Dialog(getActivity(), R.style.dialog);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        View view = FrameActivityFragmentViewHelper.getLoadingDialogView(getActivity());
        mLoadingDialog.setContentView(view);
        mLoadingDialog.setCanceledOnTouchOutside(false);

        if (!TextUtils.isEmpty(message)) {
            TextView textView = view.findViewById(R.id.txt_progress_tips);
            textView.setText(message);
        }
        return mLoadingDialog;
    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return view;
//    }


}
