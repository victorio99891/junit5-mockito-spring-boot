package pl.wiktor.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChildOne implements Parent {

    @Override
    public void showText() {
        log.debug("Text from child one.");
    }
}
