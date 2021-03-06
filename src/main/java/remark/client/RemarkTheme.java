package remark.client;


import com.google.gwt.core.client.ScriptInjector;
import remark.resources.RemarkBundle;

public class RemarkTheme {
    public static void init() {
        final RemarkBundle bundle = RemarkBundle.INSTANCE;

        /* Order Matters */

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // JS
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        // Core
        ScriptInjector.fromString(bundle.js_jquery().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_bootstrap().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_animsition().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_asScroll().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_mouseWheel().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_asScrollable().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_asHoverScroll().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();

        // Plugins
        ScriptInjector.fromString(bundle.js_switchery().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_introJs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_screenfull().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_slidepanel().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_jqueryPlaceholder().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_spin().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_ladda().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
//        ScriptInjector.fromString(bundle.js_chartist().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_gmaps().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_match_height().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_autosize().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_floatThead().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_treeview().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_orgChart().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_chartjs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_fullcalendar().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_select2().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();

        // Scripts
        ScriptInjector.fromString(bundle.js_core().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_site().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
//        ScriptInjector.fromString(bundle.js_menu().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
//        ScriptInjector.fromString(bundle.js_menubar().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
//        ScriptInjector.fromString(bundle.js_gridmenu().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_sidebar().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_configColors().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_configTour().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_asScrollable().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_animsition().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_slidepanel().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_switchery().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_jqueryPlaceholder().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_gmaps().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromString(bundle.js_comp_match_height().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Configure / Patch
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        patchBootstrapModal();
    }

    // Patch bs modal so Select2 controls can be in modals and receive focus on their text search input
    private static native void patchBootstrapModal() /*-{
        $wnd.$.fn.modal.Constructor.prototype.enforceFocus = function () {
        };
    }-*/;
}
