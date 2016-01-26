package remark.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface RemarkBundle extends ClientBundle {
    RemarkBundle INSTANCE = GWT.create(RemarkBundle.class);


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // JS Resources
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // JS Core
    @ClientBundle.Source("vendor/jquery/jquery.js")
    TextResource js_jquery();

    @ClientBundle.Source("vendor/bootstrap/bootstrap.js")
    TextResource js_bootstrap();

    @ClientBundle.Source("vendor/animsition/animsition.js")
    TextResource js_animsition();

    @ClientBundle.Source("vendor/asscroll/jquery-asScroll.js")
    TextResource js_asScroll();

    @ClientBundle.Source("vendor/mousewheel/jquery.mousewheel.js")
    TextResource js_mouseWheel();

    @ClientBundle.Source("vendor/asscrollable/jquery.asScrollable.all.js")
    TextResource js_asScrollable();

    @ClientBundle.Source("vendor/ashoverscroll/jquery-asHoverScroll.js")
    TextResource js_asHoverScroll();

    // JS Plugins

    @ClientBundle.Source("vendor/switchery/switchery.min.js")
    TextResource js_switchery();

    @ClientBundle.Source("vendor/intro-js/intro.js")
    TextResource js_introJs();

    @ClientBundle.Source("vendor/screenfull/screenfull.js")
    TextResource js_screenfull();

    @ClientBundle.Source("vendor/slidepanel/jquery-slidePanel.js")
    TextResource js_slidepanel();

    @ClientBundle.Source("vendor/jquery-placeholder/jquery.placeholder.js")
    TextResource js_jqueryPlaceholder();

    @ClientBundle.Source("vendor/ladda-bootstrap/ladda.js")
    TextResource js_ladda();

    @ClientBundle.Source("vendor/ladda-bootstrap/spin.js")
    TextResource js_spin();

    @ClientBundle.Source("vendor/chartist-js/chartist.js")
    TextResource js_chartist();

    @ClientBundle.Source("vendor/gmaps/gmaps.js")
    TextResource js_gmaps();

    @ClientBundle.Source("vendor/matchheight/jquery.matchHeight.js")
    TextResource js_match_height();

    @ClientBundle.Source("vendor/autosize/autosize.js")
    TextResource js_autosize();

    @ClientBundle.Source("vendor/jquery-floatthead/jquery.floatThead.js")
    TextResource js_floatThead();

    @ClientBundle.Source("vendor/bootstrap-treeview/bootstrap-treeview.min.js")
    TextResource js_treeview();

    // JS Scripts

    @ClientBundle.Source("js/core.min.js")
    TextResource js_core();

    @ClientBundle.Source("js/site.min.js")
    TextResource js_site();

    @ClientBundle.Source("js/sections/menu.js")
    TextResource js_menu();

    @ClientBundle.Source("js/sections/menubar.js")
    TextResource js_menubar();

    @ClientBundle.Source("js/sections/gridmenu.js")
    TextResource js_gridmenu();

    @ClientBundle.Source("js/sections/sidebar.js")
    TextResource js_sidebar();

    @ClientBundle.Source("js/configs/config-colors.js")
    TextResource js_configColors();

    @ClientBundle.Source("js/configs/config-tour.js")
    TextResource js_configTour();

    @ClientBundle.Source("js/components/asscrollable.js")
    TextResource js_comp_asScrollable();

    @ClientBundle.Source("js/components/animsition.js")
    TextResource js_comp_animsition();

    @ClientBundle.Source("js/components/slidepanel.js")
    TextResource js_comp_slidepanel();

    @ClientBundle.Source("js/components/switchery.js")
    TextResource js_comp_switchery();

    @ClientBundle.Source("js/components/jquery-placeholder.js")
    TextResource js_comp_jqueryPlaceholder();

    @ClientBundle.Source("js/components/gmaps.js")
    TextResource js_comp_gmaps();

    @ClientBundle.Source("js/components/matchheight.js")
    TextResource js_comp_match_height();

//    @ClientBundle.Source("js/examples/apps/message.js")
//    TextResource js_app_message();


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Css Resources
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // Pages

    @ClientBundle.Source("css/pages/login-v2.css")
    TextResource css_pages_login_v2();

    @ClientBundle.Source("css/pages/forgot-password.css")
    TextResource css_pages_forgot_password();

    @ClientBundle.Source("css/dashboard/v2.css")
    TextResource css_dashboard_v2();

    @ClientBundle.Source("css/pages/user.css")
    TextResource css_user();

    // Apps

    @ClientBundle.Source("css/apps/message.css")
    TextResource css_apps_message();
}
