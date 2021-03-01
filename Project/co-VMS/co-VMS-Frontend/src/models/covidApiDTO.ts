export class CovidApiDTO {
  constructor(
    public active: number,
    public confirmed: number,
    public deceased: number,
    public recovered: number
  ) {}
}
