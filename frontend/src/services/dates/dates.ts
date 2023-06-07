import "dayjs/locale/pl";

import dayjs from "dayjs";
import relativeTime from "dayjs/plugin/relativeTime";
import updateLocale from "dayjs/plugin/updateLocale";
import utc from "dayjs/plugin/utc";

dayjs.locale("pl");
dayjs.extend(relativeTime);
dayjs.extend(updateLocale);
dayjs.extend(utc);

export const toDottedDate = (date: Date | string): string => dayjs(date).format("DD.MM.YYYY");

export const DATE_API_FORMAT = "YYYY-MM-DD";

export default dayjs;
