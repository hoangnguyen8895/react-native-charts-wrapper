import React, { Component } from "react";
import { UIManager, findNodeHandle } from "react-native";

export default function GetOffsetEnhancer(Chart) {
  return class GetOffsetEnhancer extends Chart {
    getOffset() {
      UIManager.dispatchViewManagerCommand(
        findNodeHandle(this.getNativeComponentRef()),
        UIManager.getViewManagerConfig(this.getNativeComponentName()).Commands
          .getOffset,
        []
      );
    }
  };
}
