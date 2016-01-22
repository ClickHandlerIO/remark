package remark.client.controls;

import elemental.html.ButtonElement;
import webmattr.event.MouseEventHandler;
import webmattr.react.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import static webmattr.dom.DOM.button;
import static webmattr.dom.DOM.span;

/**
 *
 */
@Singleton
public class LaddaButton extends Component<LaddaButton.Props, LaddaButton.State> {
    private final Ref<ButtonElement> REF_BTN = Ref.make();
    private final Ref<Ladda> REF_LADDA = Ref.make();

    @Inject
    public LaddaButton() {
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void componentDidMount(ReactComponent<Props, State> $this) {
        super.componentDidMount($this);

        REF_BTN.get($this, btnEl -> {
            REF_LADDA.set($this, Ladda.create(btnEl));
        });
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Render
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected State initState(ReactComponent<Props, State> $this, Props props, State state) {
        state.status = props.status != null ? props.status : LaddaStatus.DEFAULT;
        return super.initState($this, props, state);
    }

    @Override
    protected ReactElement render(ReactComponent<Props, State> $this, Props props, State state) {

        REF_LADDA.get($this, laddaEl -> {
            switch (state.status) {
                case DEFAULT:
                    laddaEl.stop();
                    break;
                case SPINNING:
                    laddaEl.start();
                    break;
            }

//            laddaEl.setProgress(props.progress);
        });

        return button($ -> $
                        .className("btn ladda-button" + " " + props.className)
                        .type(props.type)
                        .onClick(event -> {
                            if (props.onClick != null) {
                                props.onClick.handle(event);
                            }
                            state.status = LaddaStatus.SPINNING;
                            $this.setState(state);
                        })
                        .ref(REF_BTN.pipe($this, buttonEl -> {
                            buttonEl.setAttribute("data-style", $this.props().style != null ? $this.props().style.value : LaddaStyle.ZOOM_IN.value);
                            if (props.spinnerSize != null) {
                                buttonEl.setAttribute("data-size", props.spinnerSize.value);
                            }

                        })),
                span($ -> $.className("ladda-label"),
                        props.children
                )
        );
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Props
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public enum LaddaStatus {
        DEFAULT,
        SPINNING
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public enum LaddaStyle {
        EXPAND_LEFT("expand-left"),
        EXPAND_RIGHT("expand-right"),
        EXPAND_UP("expand-up"),
        EXPAND_DOWN("expand-down"),
        ZOOM_IN("zoom-in"),
        ZOOM_OUT("zoom-out"),
        SLIDE_LEFT("slide-left"),
        SLIDE_RIGHT("slide-right"),
        SLIDE_UP("slide-up"),
        SLIDE_DOWN("slide-down"),
        CONTRACT("contract");

        public String value;

        LaddaStyle(String value) {
            this.value = value;
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Settings
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public enum SpinnerSize {
        XS("xs"),
        S("s"),
        L("l");

        public String value;

        SpinnerSize(String value) {
            this.value = value;
        }
    }

    public static class Props extends BaseProps {
        public String className;
        public String type;
        public MouseEventHandler onClick;

        public LaddaStatus status;
        public double progress; // (0.0 - 1.0)
        public LaddaStyle style;
        public SpinnerSize spinnerSize;

        @Inject
        public Props() {
        }


        public Props className(String className) {
            this.className = className;
            return this;
        }

        public Props type(String type) {
            this.type = type;
            return this;
        }

        public Props onClick(MouseEventHandler onClick) {
            this.onClick = onClick;
            return this;
        }

        public Props status(LaddaStatus status) {
            this.status = status;
            return this;
        }

        public Props progress(double progress) {
            this.progress = progress;
            return this;
        }

        public Props style(LaddaStyle style) {
            this.style = style;
            return this;
        }

        public Props spinnerSize(SpinnerSize spinnerSize) {
            this.spinnerSize = spinnerSize;
            return this;
        }
    }

    public static class State {
        LaddaStatus status;

        @Inject
        public State() {
        }
    }
}
