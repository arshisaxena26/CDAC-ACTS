import { State } from "./state";

export class District {
  constructor(
    public id: number,
    public districtName: string,
    public state: State
  ) {}
}
