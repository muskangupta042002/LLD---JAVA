package org.muskan;

public class LLD extends Course{
    @Override
    public void createCourse() {
        modules.add(new ConceptModules());
        modules.add(new ExecutorModule());
    }
}
