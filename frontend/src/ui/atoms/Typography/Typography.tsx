"use client";

import type { TypographyProps as MuiTypographyProps } from "@mui/material";
import { Typography as MuiTypography } from "@mui/material";
import { FC } from "react";

export type TypographyProps = MuiTypographyProps;

const Typography: FC<TypographyProps> = (props) => {
  const { children, ...rest } = props;

  return <MuiTypography {...rest}>{children}</MuiTypography>;
};

export default Typography;
