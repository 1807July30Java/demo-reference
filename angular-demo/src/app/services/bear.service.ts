import { BearList } from "../models/bear-list.model";
import { Bear } from "../models/bear.model";
import { Cave } from "../models/cave.model";
import { BearType } from "../models/bear-type.model";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import {HttpClient } from '@angular/common/http';


@Injectable()
export class BearService {

    // inject HttpClient
    constructor(private httpClient: HttpClient) {}

    public fetchBearInformation(id: number): Observable<Bear> {
        return this.httpClient.get<Bear>(`https://pokeapi.co/api/v2/pokemon/${id}`);
    }

    // get list of bears
    public fetchAllBears(): BearList {
        const bear1 = new Bear(3, "Steve", new Cave(5, "Camp Awesome", 7), new BearType(8, "Grizzly"), 400, new Date());
        const bear2 = new Bear(8, "Nick", new Cave(5, "Camp Awesome", 7), new BearType(8, "Grizzly"), 600, new Date());
        return new BearList([bear1, bear2]);
    }
}
