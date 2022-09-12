package ac.fusion.framework.test;

import ac.fusion.framework.plugin.FusionPlugin;

public class TestPlugin extends FusionPlugin {
    @Override
    public void onEnable() {
        System.out.println("enabled lol");
    }

    @Override
    public void onDisable() {
        System.out.println("disabled lol");
    }
}
