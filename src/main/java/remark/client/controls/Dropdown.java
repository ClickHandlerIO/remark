package remark.client.controls;

import elemental.dom.Element;
import elemental.html.AnchorElement;
import io.clickhandler.web.react.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import static io.clickhandler.web.dom.DOM.*;

/**
 *
 */
@Singleton
public class Dropdown extends Component<Dropdown.Props, Dropdown.State> {
    public final Item item;
    public final Separator separator;
    private final Ref<AnchorElement> REF = Ref.make();

    @Inject
    public Dropdown(Item item, Separator separator) {
        this.item = item;
        this.separator = separator;
    }

    private native void wire(Element element) /*-{
        $wnd.$(element).dropdown();
    }-*/;

    @Override
    protected void componentDidMount(ReactComponent<Props, State> $this) {
        super.componentDidMount($this);

        // Wire up Bootstrap.
        REF.get($this, this::wire);
    }

    @Override
    protected ReactElement render(ReactComponent<Props, State> $this, Props props, State state) {
        return
            div($ -> $.className("dropdown"),
                a($ -> $.ref(REF).set("data-toggle", "dropdown").className("dropdown-toggle").role("button"),
                    props.linkText),
                ul($ -> $.className("dropdown-menu dropdown-menu-left dropdown-menu-primary"),
                    props.children));
    }

    public static class Props extends BaseProps {
        public String linkText;
        public String className;

        @Inject
        public Props() {
        }

        public Props linkText(String linkText) {
            this.linkText = linkText;
            return this;
        }

        public Props className(String className) {
            this.className = className;
            return this;
        }
    }

    public static class State {
        @Inject
        public State() {
        }
    }

    @Singleton
    public static class Item extends StaticComponent {
        @Inject
        public Item() {
        }

        @Override
        protected ReactElement render(ReactComponent<BaseProps, Object> $this, BaseProps props) {
            return li(props.children);
        }
    }

    @Singleton
    public static class Separator extends StaticComponent {
        @Inject
        public Separator() {
        }

        @Override
        protected ReactElement render(ReactComponent<BaseProps, Object> $this, BaseProps props) {
            return li($ -> $.className("divider").role("separator"));
        }
    }
}
