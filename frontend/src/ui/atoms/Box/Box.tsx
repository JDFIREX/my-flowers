"use client";

import type { BoxProps as MuiBoxProps } from "@mui/material";
import { Box as MuiBox } from "@mui/material";
import { FC } from "react";

export type BoxProps = MuiBoxProps;

const Box: FC<BoxProps> = (props) => {
  const { children, ...rest } = props;

  return <MuiBox {...rest}>{children}</MuiBox>;
};

export default Box;
