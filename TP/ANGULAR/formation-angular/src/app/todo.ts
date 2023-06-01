export class Todo {
  // monTodo.id = 1 | monTodo.id
  // au lieu de monTodo.setId(1) | monTodo.getId()
  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }
  
  public get title(): string {
    return this._title;
  }

  public set title(value: string) {
    this._title = value;
  }

  public get completed(): boolean {
    return this._completed ?? false;
  }

  public set completed(value: boolean) {
    this._completed = value;
  }
  
  public get userId(): number {
    return this._userId ?? 0;
  }

  public set userId(value: number) {
    this._userId = value;
  }
  
  constructor(
    private _id: number,
    private _title: string,
    private _completed?: boolean,
    private _userId?: number
  ) { }
}
