"use client";

import { CssBaseline, StyledEngineProvider, theme, ThemeProvider } from "@ui/theme";
import React, { FC, ReactNode } from "react";

interface Props {
  children: ReactNode;
}

const MuiLayout: FC<Props> = (props) => {
  const { children } = props;

  return (
    <ThemeProvider theme={theme}>
      <StyledEngineProvider injectFirst>
        <CssBaseline />
        {children}
      </StyledEngineProvider>
    </ThemeProvider>
  );
};

export default MuiLayout;
