import "server-only";

import MuiLayout from "@app/mui.layout";
import React, { FC, ReactNode } from "react";

export const metadata = {
  title: "my-flowers",
  description: "store information about your flowers"
};

interface Props {
  children: ReactNode;
}

const RootLayout: FC<Props> = (props) => {
  const { children } = props;

  return (
    <html lang="en">
      <body>
        <React.StrictMode>
          <MuiLayout>{children}</MuiLayout>
        </React.StrictMode>
      </body>
    </html>
  );
};

export default RootLayout;
