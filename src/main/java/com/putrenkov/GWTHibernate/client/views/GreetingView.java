package com.putrenkov.GWTHibernate.client.views;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface GreetingView extends IsWidget {

    Label getGreetingLabel();

    Anchor getLogOutAncor();

    void setPresenter(Presenter presenter);

    void clearView();

    interface Presenter {
	void logOut();
    }

}
