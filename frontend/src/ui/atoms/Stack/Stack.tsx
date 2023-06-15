"use client";

import type { StackProps as MuiStackProps } from "@mui/material";
import { Stack as MuiStack } from "@mui/material";
import { FC } from "react";

export type StackProps = MuiStackProps;

const Stack: FC<StackProps> = (props) => {
  const { children, ...rest } = props;

  return <MuiStack {...rest}>{children}</MuiStack>;
};

export default Stack;
