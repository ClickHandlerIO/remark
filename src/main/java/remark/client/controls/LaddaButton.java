package remark.client.controls;

import elemental.html.ButtonElement;
import io.clickhandler.web.dom.CSSProps;
import io.clickhandler.web.event.MouseEventHandler;
import io.clickhandler.web.react.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import static io.clickhandler.web.dom.DOM.button;
import static io.clickhandler.web.dom.DOM.span;

/**
 *
 */
@Singleton
public class LaddaButton extends Component<LaddaButton.Props, LaddaButton.State> {
    private final Ref<ButtonElement> refBtn = Ref.make();
    private final Ref<Ladda> refLadda = Ref.make();

    @Inject
    public LaddaButton() {
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Lifecycle
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void componentDidMount(ReactComponent<Props, State> $this) {
        super.componentDidMount($this);

        refBtn.get($this, btnEl -> {
            refLadda.set($this, Ladda.create(btnEl));
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

        refLadda.get($this, laddaEl -> {
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
                        .style(new CSSProps())
                        .onClick(event -> {
                            if (props.onClick != null) {
                                props.onClick.handle(event);
                            }
                        })
                        .ref(refBtn)
                        .set("data-style", props.laddaStyle != null ? props.laddaStyle.value : LaddaStyle.ZOOM_IN.value)
                        .set("data-size", props.spinnerSize != null ? props.spinnerSize.value : null),
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
        public CSSProps style;
        public MouseEventHandler onClick;
        public LaddaStatus status;

        public boolean spinning;
        public double progress; // (0.0 - 1.0)
        public LaddaStyle laddaStyle;
        public SpinnerSize spinnerSize;

        @Inject
        public Props() {
        }

        public Props type(final String type) {
            this.type = type;
            return this;
        }

        public LaddaStatus status() {
            return this.status;
        }

        public Props status(final LaddaStatus status) {
            this.status = status;
            return this;
        }


        public Props laddaStyle(final LaddaStyle laddaStyle) {
            this.laddaStyle = laddaStyle;
            return this;
        }

        public Props onClick(final MouseEventHandler onClick) {
            this.onClick = onClick;
            return this;
        }

        public Props progress(final double progress) {
            this.progress = progress;
            return this;
        }

        public Props spinnerSize(final SpinnerSize spinnerSize) {
            this.spinnerSize = spinnerSize;
            return this;
        }

        public Props spinning(final boolean spinning) {
            this.spinning = spinning;
            return this;
        }

        public Props style(final CSSProps style) {
            this.style = style;
            return this;
        }

        public Props className(final String className) {
            this.className = className;
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
