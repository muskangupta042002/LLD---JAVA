package org.muskan;

public class HLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new DemoModule());
        modules.add(new ConceptModules());
    }
}
